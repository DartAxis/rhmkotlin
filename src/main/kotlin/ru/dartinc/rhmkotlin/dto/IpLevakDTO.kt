package ru.dartinc.rhmkotlin.dto

import ru.dartinc.rhmkotlin.model.IpLevak

data class IpLevakDTO(
    var id: Long? = null,
    var ip: String? = "",
    var hostName: String? = "",
    var country: String? = "",
    var lastActive: String? = ""
) {
    constructor(ipLevak: IpLevak) : this() {
        id = ipLevak.id
        ip = ipLevak.ip
        hostName = ipLevak.hostName
        country = ipLevak.country
        lastActive = ipLevak.lastActive.toString()
    }
}
