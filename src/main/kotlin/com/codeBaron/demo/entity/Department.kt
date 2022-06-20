package com.codeBaron.demo.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Department(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)  var departmentId: Int = 0,
    @NotBlank(message = "Department name is missing")
    var departmentName: String? = null,
    @NotBlank(message = "Department address is missing")
    var departmentAddress: String? = null,
    @NotBlank(message = "Department code is missing")
    var departmentCode: String? = null
)

