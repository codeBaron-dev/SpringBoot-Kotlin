package com.codeBaron.demo.repository

import com.codeBaron.demo.entity.Department
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DepartmentRepository : JpaRepository<Department, Int> {

    fun findByDepartmentName(name: String): Department
    fun findByDepartmentNameIgnoreCase(name: String): Department
}