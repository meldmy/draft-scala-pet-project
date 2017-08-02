package core.concurrent

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

/**
  * @author Dmytro Melnychuk
  */
class AsyncCalculation {
  val sumF = Future {
    (1L to 5L).sum
  }

  sumF onSuccess {
    case s => println(s"s = $s")
  }

  val doubledSumF: Future[Long] = sumF.map(_ * 2)

  val tripledSumF: Future[Long] = sumF.flatMap {
    case s => Future {
      s * 3
    }
  }

  val resultF: Future[Long] = for {
    s1 <- doubledSumF
    s2 <- tripledSumF
  } yield s1 + s2

  val result = Await.result(resultF, Duration(100, "second"))
  println(s"result = $result")
}

object AsyncCalculation extends App {
  private val calculation = new AsyncCalculation()
  calculation.sumF

  val s = """В частности, о комбинаторе sequence, с помощью которого можно получить
Future[Seq[X]] из Seq[Future[X]].Или blocking, предназначенном для оборачивания
блокируемого куска кода, и о том, как он работает.Или о промисах (promises) — контейнерах,
в которые можно записывать футуры, но только один раз."""

  val v2 = "вы можете обернуть десять функций в одну футуру, тем самым гарантируя, что запрос" +
    " пользователя обработается за N мс, без прерывания где-то посередине на обработку пары сотен " +
    "других запросов, чего вам никогда не позволит Erlang. Или представьте, что ваша программа делает много " +
    "тяжелых вычислений, например, обучает нейронные сети. Если все потоки легковесные, то накладные расходны " +
    "на их шедулинг могут существенно замедлить вычисления." +
    "Реализовать поддержку как блокирующих, так и неблокирующих вызовов без футур довольно непросто"
}


