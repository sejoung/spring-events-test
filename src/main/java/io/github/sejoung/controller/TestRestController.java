package io.github.sejoung.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.sejoung.service.TestService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class TestRestController {

  private final TestService service;

  @RequestMapping("/")
  public ResponseEntity<String> test() {
    service.test();
    return ResponseEntity.ok("test");
  }
}
