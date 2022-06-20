package com.codeBaron.demo.controller

import com.codeBaron.demo.entity.Department
import com.codeBaron.demo.service.DepartmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class DepartmentController {

    @Autowired
    val departmentService: DepartmentService? = null

    @PostMapping("/departments")
    fun saveDepartments(@Valid @RequestBody department: Department?) =
        department?.let { departmentService?.saveDepartments(it) }

    @GetMapping("/departments")
    fun fetchDepartments() = departmentService?.fetchDepartments()

    @GetMapping("/departments/{id}")
    fun getDepartmentById(@PathVariable("id") id: Int) = departmentService?.getDepartmentById(id)

    @DeleteMapping("/departments/{id}")
    fun deleteDepartmentById(@PathVariable("id") id: Int): String {
        departmentService?.deleteDepartmentById(id)
        return "Deleted successfully"
    }

    @PutMapping("/departments/{id}")
    fun updateDepartmentById(@PathVariable("id") id: Int, @RequestBody department: Department?) =
        departmentService?.updateDepartmentById(id, department)

    @GetMapping("/departments/name/{name}")
    fun fetchDepartmentName(@PathVariable("name") name: String) = departmentService?.fetchDepartmentName(name)
}