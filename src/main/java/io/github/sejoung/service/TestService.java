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
    repository.save(Person.builder().lastName("zolla").firstName("test").createDate(LocalDateTime.now()).build());
    eventPublisher.publishCustomEvent("잘간다.");
  }

  @Transactional
  public void testRollBack() {
    repository.save(Person.builder().lastName("zolla").firstName("test").createDate(LocalDateTime.now()).build());
    eventPublisher.publishCustomEvent("롤백테스트");
    throw new RuntimeException("에러닷");
  }
}
