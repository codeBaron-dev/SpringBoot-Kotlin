package com.codeBaron.demo.service

import com.codeBaron.demo.entity.Department
import com.codeBaron.demo.repository.DepartmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DepartmentServiceImplementation : DepartmentService {

    @Autowired
    val departmentRepository: DepartmentRepository? = null

    override fun saveDepartments(department: Department): Department? = departmentRepository?.save(department)

    override fun fetchDepartments(): List<Department?> = departmentRepository?.findAll() as List<Department?>

    override fun getDepartmentById(id: Int): Department? = departmentRepository?.findById(id)?.get()

    override fun deleteDepartmentById(id: Int): String = departmentRepository?.deleteById(id).toString()

    override fun updateDepartmentById(id: Int, department: Department?): Department? {
       val departmentDataFromDb: Department? = departmentRepository?.findById(id)?.get()
       when {
           department?.departmentName?.isNotBlank() == true -> {
               departmentDataFromDb?.departmentName = department.departmentName
           }
           department?.departmentCode?.isNotBlank() == true -> {
               departmentDataFromDb?.departmentCode = department.departmentCode
           }
           department?.departmentAddress?.isNotBlank() == true -> {
               departmentDataFromDb?.departmentAddress = department.departmentAddress
           }
       }
        return departmentRepository?.save(departmentDataFromDb!!)
    }

    override fun fetchDepartmentName(name: String) = departmentRepository?.findByDepartmentNameIgnoreCase(name)
}