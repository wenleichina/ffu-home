package com.funzuqiu.ffu.home.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowDeploymentInfoCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.undertow.Undertow.Builder;
import io.undertow.server.HttpServerExchange;
import io.undertow.servlet.api.ConfidentialPortManager;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.SecurityConstraint;
import io.undertow.servlet.api.SecurityInfo.EmptyRoleSemantic;
import io.undertow.servlet.api.TransportGuaranteeType;
import io.undertow.servlet.api.WebResourceCollection;

@Configuration
@ConditionalOnProperty(value = "server.ssl.enabled", havingValue = "true")
public class NetworkConfig {

    @Bean
    public ServletWebServerFactory servletContainer() {
        UndertowServletWebServerFactory undertow = new UndertowServletWebServerFactory();
        undertow.addBuilderCustomizers(new UndertowBuilderCustomizer() {
            @Override
            public void customize(Builder builder) {
                builder.addHttpListener(80, "0.0.0.0");
            }
        });
        undertow.addDeploymentInfoCustomizers(new UndertowDeploymentInfoCustomizer() {
            @Override
            public void customize(DeploymentInfo deploymentInfo) {
                deploymentInfo
                        .addSecurityConstraint(
                                new SecurityConstraint().setTransportGuaranteeType(TransportGuaranteeType.CONFIDENTIAL)
                                        .addWebResourceCollections(new WebResourceCollection().addUrlPatterns("/*"))
                                        .setEmptyRoleSemantic(EmptyRoleSemantic.PERMIT))
                        .setConfidentialPortManager(new ConfidentialPortManager() {
                            @Override
                            public int getConfidentialPort(HttpServerExchange exchange) {
                                return 443;
                            }
                        });
            }
        });
        return undertow;
    }

}
