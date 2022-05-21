package ru.dartinc.rhmkotlin.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.dartinc.rhmkotlin.dto.IpLevakDTO
import ru.dartinc.rhmkotlin.model.IpLevak
import ru.dartinc.rhmkotlin.repositories.IpLevakRepository
import java.time.LocalDateTime

@Service
class IpLevakService @Autowired constructor(val repository: IpLevakRepository) {

    fun add(ipLevakDTO: IpLevakDTO): IpLevak {
        val ipLevak = IpLevak()
        ipLevak.ip = ipLevakDTO.ip
        ipLevak.hostName = ipLevakDTO.hostName
        ipLevak.country = ipLevakDTO.country
        ipLevak.lastActive = LocalDateTime.parse(ipLevakDTO.lastActive)
        return ipLevak
    }

    fun add(ipLevak: IpLevak?): IpLevak? {
        return if (ipLevak != null) {
            repository.save(ipLevak)
            ipLevak
        } else {
            null
        }
    }

    fun getAll():List<IpLevak>{
        return repository.findAll()
    }
}