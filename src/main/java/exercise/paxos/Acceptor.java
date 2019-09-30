package exercise.paxos;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: Liuyuming
 * @Date: 2019/9/30 10:59
 */
public class Acceptor {
    public static String electValue(List<Proposer> proposers) {
        // 按照value count分组，count>size/2 即为选定value
        Map<String, Long> valueStatistic = proposers.stream().map(Proposer::getValue).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Map.Entry<String, Long> entry : valueStatistic.entrySet()) {
            if (entry.getValue() >= proposers.size() / 2) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * 超过半数以上的选举为主节点
     * @param proposers
     * @return
     */
    public static Proposer electMaster(List<Proposer> proposers) {
        String value = electValue(proposers);
        Optional<Proposer> minSerializableNumberProposer = proposers.stream().filter(it -> value.equals(it.getValue())).sorted(Comparator.comparingLong(Proposer::getSerialNumber)).findFirst();
        return minSerializableNumberProposer.orElse(null);
    }

    public static void main(String[] args) {
        List<Proposer> proposers = new ArrayList<>();
        proposers.add(new Proposer("a",123L));
        proposers.add(new Proposer("b",124L));
        proposers.add(new Proposer("a",125L));
        proposers.add(new Proposer("c",126L));
        proposers.add(new Proposer("c",127L));
        proposers.add(new Proposer("c",128L));
        proposers.add(new Proposer("b",129L));
        String value = electValue(proposers);
        System.out.println(value);
        Proposer proposer = electMaster(proposers);
        System.out.println();
    }
}

