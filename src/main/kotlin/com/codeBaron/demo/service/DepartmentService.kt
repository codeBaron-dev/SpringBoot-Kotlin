package com.codeBaron.demo.service

import com.codeBaron.demo.entity.Department

interface DepartmentService {
    fun saveDepartments(department: Department): Department?
    fun fetchDepartments(): List<Department?>
    fun getDepartmentById(id: Int): Department?
    fun deleteDepartmentById(id: Int): String
    fun updateDepartmentById(id: Int, department: Department?): Department?
    fun fetchDepartmentName(name: String): Department?
}