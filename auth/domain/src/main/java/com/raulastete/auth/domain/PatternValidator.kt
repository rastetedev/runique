package com.raulastete.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}