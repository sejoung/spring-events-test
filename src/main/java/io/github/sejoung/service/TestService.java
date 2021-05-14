package io.github.sejoung.service;

import java.time.LocalDateTime;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.github.sejoung.entity.Person;
import io.github.sejoung.publisher.TestSpringEventPublisher;
import io.github.sejoung.repository.PersonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TestService {
  private final PersonRepository repository;
  private final TestSpringEventPublisher eventPublisher;

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void test() {
    repository.save(Person.builder().lastName("zolla").firstName("test").createDate(LocalDateTime.now()).build());
    eventPublisher.publishCustomEvent("잘간다.");
  }
}
