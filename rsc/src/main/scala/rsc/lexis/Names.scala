// Copyright (c) 2017 Twitter, Inc.
// Licensed under the Apache License, Version 2.0 (see LICENSE.md).
package rsc.lexis

import rsc.util._

trait Names {
  implicit class NameOps(value: String) {
    def isLeftAssoc: Boolean = {
      !isRightAssoc
    }

    def isRightAssoc: Boolean = {
      value.endsWith(":")
    }

    def isOpAssignment: Boolean = {
      if (value.isEmpty) false
      else if (value == "!=" || value == "<=" || value == ">=") false
      else {
        val headCh = value.charAt(0)
        val headOk = headCh != '=' && isSymbolicIdStart(headCh)
        val lastOk = value.last == '='
        headOk && lastOk
      }
    }

    def precedence: Int = {
      if (value.isEmpty || value.isOpAssignment) {
        0
      } else {
        val headCh = value.charAt(0)
        if (isAlphanumericIdStart(headCh)) {
          1
        } else {
          headCh match {
            case '|' => 2
            case '^' => 3
            case '&' => 4
            case '=' | '!' => 5
            case '<' | '>' => 6
            case ':' => 7
            case '+' | '-' => 8
            case '*' | '/' | '%' => 9
            case _ => 10
          }
        }
      }
    }
  }
}
