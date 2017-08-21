package com.heshidai.gold.console.common.jedis;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * 功能：JedisClusterFactory
 *
 * @version 2017年1月4日下午3:41:26
 * @author baocheng.ren
 */
public class JedisClusterFactory implements FactoryBean<JedisCluster>, InitializingBean {
    
    private static final int NUMBER_2000 = 2000;
    private static final int NUMBER_3000 = 3000;
    private static final int NUMBER_5 = 5;
    
    private String address;
    
    private JedisCluster jedisCluster;
    private Integer connectionTimeout = NUMBER_2000;
    private Integer soTimeout = NUMBER_3000;
    private Integer maxRedirections = NUMBER_5;
    private GenericObjectPoolConfig genericObjectPoolConfig;
    
    @Override
    public JedisCluster getObject() throws Exception {
        return jedisCluster;
    }
    
    @Override
    public Class<? extends JedisCluster> getObjectType() {
        return (this.jedisCluster != null ? this.jedisCluster.getClass() : JedisCluster.class);
    }
    
    @Override
    public boolean isSingleton() {
        return true;
    }
    
    /**
     * 功能：parseHostAndPort
     *
     * @version 2017年1月4日下午3:41:45
     * @author baocheng.ren
     * @return Set<HostAndPort>
     * @throws Exception Exception
     */
    private Set<HostAndPort> parseHostAndPort() throws Exception {
        try {
            String[] addressArr = address.trim().split(",");
            Set<HostAndPort> haps = new HashSet<HostAndPort>();
            for (String addressStr : addressArr) {
                String[] ipAndPort = addressStr.trim().split(":");
                HostAndPort hap = new HostAndPort(ipAndPort[0].trim(), Integer.parseInt(ipAndPort[1].trim()));
                haps.add(hap);
            }
            
            return haps;
        }
        catch (IllegalArgumentException ex) {
            throw ex;
        }
        catch (Exception ex) {
            throw new Exception("解析 jedis 配置文件失败", ex);
        }
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        Set<HostAndPort> haps = this.parseHostAndPort();
        jedisCluster = new JedisCluster(haps, connectionTimeout, soTimeout, maxRedirections, genericObjectPoolConfig);
    }
    
    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * @param connectionTimeout the connectionTimeout to set
     */
    public void setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }
    
    /**
     * @param soTimeout the soTimeout to set
     */
    public void setSoTimeout(Integer soTimeout) {
        this.soTimeout = soTimeout;
    }
    
    /**
     * @param maxRedirections the maxRedirections to set
     */
    public void setMaxRedirections(Integer maxRedirections) {
        this.maxRedirections = maxRedirections;
    }
    
    /**
     * @param genericObjectPoolConfig the genericObjectPoolConfig to set
     */
    public void setGenericObjectPoolConfig(GenericObjectPoolConfig genericObjectPoolConfig) {
        this.genericObjectPoolConfig = genericObjectPoolConfig;
    }
    
}
