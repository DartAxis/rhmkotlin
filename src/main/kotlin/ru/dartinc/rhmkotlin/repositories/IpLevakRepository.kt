package ru.dartinc.rhmkotlin.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.dartinc.rhmkotlin.model.IpLevak

interface IpLevakRepository: JpaRepository<IpLevak, Long>