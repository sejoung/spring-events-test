package io.github.sejoung.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class RestAdvice {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception exception) {
    log.error("Exception ", exception);
    return ResponseEntity.ok("rest error");
  }
}
