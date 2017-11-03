package top.blentle.prairie.core.registry;

import top.blentle.prairie.core.exceptions.NuSuchServiceDefinitionException;
import top.blentle.prairie.core.exceptions.PersistServiceDefinitionException;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/11/3 0003
 * @description :
 * @since : 1.0
 */
public interface ServiceRegistry {
    /**
     * Register a service interface with this registry
     * @param serviceName
     * @param serviceDefinition
     * @throws PersistServiceDefinitionException
     */
    void registerServiceDefinition(String serviceName, ServiceDefinition serviceDefinition) throws PersistServiceDefinitionException;

    /**
     * get all registered service definitions
     * @return the amount of all registered service definitions
     * @throws NuSuchServiceDefinitionException
     */
    int getServiceDefinitionCount() throws NuSuchServiceDefinitionException;

    /**
     * get service definition by name
     * @param serviceName serviceDefinition name
     * @return service definition
     * @throws NuSuchServiceDefinitionException
     */
    ServiceDefinition getServiceDefinition(String serviceName) throws NuSuchServiceDefinitionException;

    /**
     * Remove the ServiceDefinition for the given name.
     * @param beanName the name of the service instance to register
     * @throws NuSuchServiceDefinitionException if there is no such service definition
     */
    void removeBeanDefinition(String beanName) throws NuSuchServiceDefinitionException;

}
