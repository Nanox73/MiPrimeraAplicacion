package com.example.mip.API

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object AlumnosRepository {

    suspend fun fetchAlumnos(): Result<List<Alumno>> = withContext(Dispatchers.IO) {
        try {
            Result.success(ApiDuocClient.service.getAlumnos())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun insertAlumno(request: AlumnoInsertRequest): Result<InsertResponse> = withContext(Dispatchers.IO) {
        try {
            Result.success(ApiDuocClient.service.insertAlumno(request))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}