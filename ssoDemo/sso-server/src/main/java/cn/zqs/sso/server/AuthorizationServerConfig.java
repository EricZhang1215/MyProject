package cn.zqs.sso.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * 通过继承该类并重写 configure 方法来配置授权服务器
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * 客户端属性信息
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //将数据存到创建的session中，将session存到memory，当重启系统session会丢失需要用户重新登陆授权。
        clients.inMemory()
                // client_id
                .withClient("merryyou1")
                // client_secret
                .secret("merryyousecrect1")
                // 该client允许的授权类型
                .authorizedGrantTypes("authorization_code", "refresh_token")
                // 允许的授权范围
                .scopes("all","read","write")
                // 自动授权
                .autoApprove(true)
                .and()
                .withClient("merryyou2")
                .secret("merryyousecrect2")
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("all","read","write")
                .autoApprove(true);
    }

    /**
     * 配置授权服务器端点，如令牌存储，令牌自定义，用户批准和授权类型，不包括端点安全配置
     * 配置jwttokenStore
     * 告诉Spring Security Token的生成方式
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(jwtTokenStore()).accessTokenConverter(jwtAccessTokenConverter());
    }

    /**
     * 配置授权服务器端点的安全
     * springSecurity 授权表达式，访问tokenkey时需要经过认证
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("isAuthenticated()");
    }

    /**
     * JWTtokenStore
     * @return
     */
    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    /**
     * 生成JTW token
     * 使用同一个密钥来编码 JWT 中的  OAuth2 令牌
     * @return
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("zqs");
        return converter;
    }
}
