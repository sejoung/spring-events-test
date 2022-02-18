package io.github.sejoung.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.github.sejoung.entity.Person;
import io.github.sejoung.publisher.TestSpringEventPublisher;
import io.github.sejoung.repository.PersonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TestService {
  private final PersonRepository repository;
  private final TestSpringEventPublisher eventPublisher;

  @Transactional
  public void test() {
    var person = repository.save(
      Person.builder().lastName("zolla").firstName("test").createDate(LocalDateTime.now()).build());
    eventPublisher.publishCustomEvent(person.toString());
  }

  @Transactional
  public void testRollBack() {
    var person =repository.save(Person.builder().lastName("zolla").firstName("test").createDate(LocalDateTime.now()).build());
    eventPublisher.publishCustomEvent(person.toString());
    throw new RuntimeException("에러닷");
  }
}
