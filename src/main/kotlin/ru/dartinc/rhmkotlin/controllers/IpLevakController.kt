package ru.dartinc.rhmkotlin.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.*
import org.springframework.util.ResourceUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.dartinc.rhmkotlin.dto.IpLevakDTO
import ru.dartinc.rhmkotlin.model.IpLevak
import ru.dartinc.rhmkotlin.services.IpLevakService
import java.io.FileInputStream
import java.io.InputStream
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("")
class IpLevakController @Autowired constructor(
    val service: IpLevakService,
) {

    @GetMapping(produces = [MediaType.IMAGE_JPEG_VALUE])
    fun levakEnter(request: HttpServletRequest): ResponseEntity<Any> {
        val ipLevak = IpLevak()
        ipLevak.ip = request.remoteAddr
        ipLevak.hostName = request.remoteHost
        ipLevak.lastActive = LocalDateTime.now()
        service.add(ipLevak)
        val headers = HttpHeaders()
        val file = ResourceUtils.getFile("classpath:img/cat.jpg")
        val inputStream: InputStream = FileInputStream(file)
        val media = inputStream.readAllBytes()
        headers.cacheControl = CacheControl.noCache().headerValue
        return ResponseEntity<Any>(media, headers, HttpStatus.OK)
    }

    @GetMapping("/getAll")
    fun getall(): ResponseEntity<*> {
        val result:List<IpLevakDTO> = service.getAll().map{IpLevakDTO(it)}
        return ResponseEntity.ok(result)
    }
}