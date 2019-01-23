package com.example.mechrevo.demosetapp.sealeddemo


sealed class Expr {
    data class Const(var number: Double?) : Expr()
    data class Sum(val e1: Expr, val e2: Expr) : Expr()
}