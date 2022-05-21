package ru.dartinc.rhmkotlin.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "iplevak")
data class IpLevak(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
) {
    @Column(name = "ip", nullable = false)
    var ip: String? = ""
    @Column(name = "hostname")
    var hostName: String? = ""
    @Column(name = "country")
    var country: String? = "unknown"
    @Column(name = "lastactive")
    var lastActive: LocalDateTime? = null
}