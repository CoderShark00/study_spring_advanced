package hello.advanced.app.v5;


import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class OrderServiceV5 {

    @Autowired
    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(LogTrace trace, OrderRepositoryV5 orderRepository) {
        this.template = new TraceTemplate(trace);
        this.orderRepository = orderRepository;
    }

    public void orderItem(String itemId) {
        template.execute("OrderSerivce.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}
