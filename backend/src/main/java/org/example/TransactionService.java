package org.example;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class TransactionService {

    static Random random = new Random();

    static String[] types = {"UPI", "CARD", "ATM"};
    static String[] channels = {"MOBILE", "WEB", "ATM"};
    static String[] statusList = {"SUCCESS", "FAILED"};
    static String[] locations = {"Kolkata", "Delhi", "Mumbai", "Bangalore"};

    public Transaction generateTransaction() {

        Transaction t = new Transaction();

        t.setTransactionId(UUID.randomUUID().toString());
        t.setTimestamp(LocalDateTime.now().toString());
        t.setType(types[random.nextInt(types.length)]);
        t.setChannel(channels[random.nextInt(channels.length)]);
        t.setSender("ACC" + (1000 + random.nextInt(9000)));
        t.setReceiver("ACC" + (1000 + random.nextInt(9000)));
        t.setAmount(50 + (5000 * random.nextDouble()));
        t.setStatus(statusList[random.nextInt(statusList.length)]);
        t.setIpAddress("192.168.1." + random.nextInt(255));
        t.setLocation(locations[random.nextInt(locations.length)]);

        return t;
    }

    public List<Transaction> generateMultiple(int count) {
        List<Transaction> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(generateTransaction());
        }
        return list;
    }
}
