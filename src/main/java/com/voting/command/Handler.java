package com.voting.command;

import com.voting.command.exception.CommandHandlerNotFoundException;
import com.voting.command.exception.HandlerNotImplementsException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class Handler implements ApplicationListener<ContextRefreshedEvent> {

    private final Map<Class<?>, String> handlers = new HashMap<>();
    private final ConfigurableListableBeanFactory beanFactory;

    public CommandHandler<Object, Object> getHandler(Object command) {
        String beanName = handlers.get(command.getClass());
        if (beanName == null) {
            throw new CommandHandlerNotFoundException(command.getClass());
        }
        return beanFactory.getBean(beanName, CommandHandler.class);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        handlers.clear();
        String[] handlersNames = beanFactory.getBeanNamesForType(CommandHandler.class);
        for (String beanName : handlersNames) {
            BeanDefinition commandHandler = beanFactory.getBeanDefinition(beanName);
            try {
                Class<?> handlerClass = Class.forName(commandHandler.getBeanClassName());
                handlers.put(getHandleCommandType(handlerClass), beanName);
            } catch (ClassNotFoundException e) {
                throw new HandlerNotImplementsException();
            }
        }
    }

    private Class<?> getHandleCommandType(Class <?> clazz) {
        Type [] genericInterfaces = clazz.getGenericInterfaces();
        ParameterizedType type = findByRawType(genericInterfaces);
        return (Class<?>) type.getActualTypeArguments()[0];
    }

    private ParameterizedType findByRawType(Type[] genericInterfaces) {
        for (Type type : genericInterfaces ) {
            if (type instanceof ParameterizedType parameterizedType) {
                CommandHandler.class.isAssignableFrom(parameterizedType.getRawType().getClass());
                if (CommandHandler.class.isAssignableFrom((Class<?>) parameterizedType.getRawType())) {
                    return parameterizedType;
                }
            }
        }
        throw new HandlerNotImplementsException();
    }
}
