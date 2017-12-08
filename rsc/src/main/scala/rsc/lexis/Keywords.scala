// Copyright (c) 2017 Twitter, Inc.
// Licensed under the Apache License, Version 2.0 (see LICENSE.md).
package rsc.lexis

import java.util

object Keywords {

  private val keywords: java.util.Map[String, Token] = {
    val m = new util.HashMap[String, Token]()

    Map(
      "abstract" -> ABSTRACT,
      "case" -> CASE,
      "catch" -> CATCH,
      "class" -> CLASS,
      "def" -> DEF,
      "do" -> DO,
      "else" -> ELSE,
      "extends" -> EXTENDS,
      "false" -> FALSE,
      "final" -> FINAL,
      "finally" -> FINALLY,
      "for" -> FOR,
      "forSome" -> FORSOME,
      "if" -> IF,
      "implicit" -> IMPLICIT,
      "import" -> IMPORT,
      "lazy" -> LAZY,
      "match" -> MATCH,
      "new" -> NEW,
      "null" -> NULL,
      "object" -> OBJECT,
      "override" -> OVERRIDE,
      "package" -> PACKAGE,
      "private" -> PRIVATE,
      "protected" -> PROTECTED,
      "return" -> RETURN,
      "sealed" -> SEALED,
      "super" -> SUPER,
      "this" -> THIS,
      "throw" -> THROW,
      "trait" -> TRAIT,
      "try" -> TRY,
      "true" -> TRUE,
      "type" -> TYPE,
      "val" -> VAL,
      "var" -> VAR,
      "while" -> WHILE,
      "with" -> WITH,
      "yield" -> YIELD,
      "_" -> USCORE,
      ":" -> COLON,
      "=" -> EQUALS,
      "=>" -> ARROW,
      "⇒" -> ARROW,
      "<-" -> LARROW,
      "←" -> LARROW,
      "<:" -> SUBTYPE,
      "<%" -> CATCH,
      ">:" -> SUPERTYPE,
      "#" -> HASH,
      "@" -> AT
    ).foreach { case (k, v) =>
      m.put(k, v)
    }
    m
  }

  def getTokenOrElse(element: String, default: Token): Token = {
    val value = keywords.get(element).asInstanceOf[Integer]
    val res: Token = if (value eq null) default else value
    res
  }
}

trait Keywords {
}
