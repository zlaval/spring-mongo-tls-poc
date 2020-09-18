package com.zlrx.demo.mongotls.config

import com.mongodb.connection.SslSettings
import org.apache.http.ssl.SSLContextBuilder
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import java.security.KeyManagementException
import java.security.KeyStoreException
import java.security.NoSuchAlgorithmException
import javax.net.ssl.SSLContext

@Configuration
@EnableScheduling
class MongoConfig {


    @Bean
    fun tlsCustomizer(): MongoClientSettingsBuilderCustomizer {
        return MongoClientSettingsBuilderCustomizer { builder ->
            builder.applyToSslSettings {
                it.applySettings(
                    SslSettings.builder()
                        .enabled(true)
                        .invalidHostNameAllowed(true)
                        .context(getSslContext())
                        .build()
                )
            }
//                .streamFactoryFactory(NettyStreamFactoryFactory.builder()
//                    .eventLoopGroup(NioEventLoopGroup())
            //.build())

        }
    }

    private fun getSslContext(): SSLContext? {
        return try {
            SSLContextBuilder()
                .loadTrustMaterial(null) { _, _ -> true }
                .build()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
            throw RuntimeException("NoSuchAlgorithmException")
        } catch (e: KeyManagementException) {
            e.printStackTrace()
            throw RuntimeException("KeyManagementException")
        } catch (e: KeyStoreException) {
            e.printStackTrace()
            throw RuntimeException("KeyStoreException")
        }
    }

}