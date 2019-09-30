package exercise.paxos;

/**
 * @Author: Liuyuming
 * @Date: 2019/9/30 10:58
 */
public class Proposer {
    private String host;

    private String value;

    /**
     * 机器编号，zookeeper 选择最小的为master
     */
    private Long serialNumber;

    public Proposer() {
    }

    public Proposer(String value) {
        this.value = value;
    }

    public Proposer(String value, Long serialNumber) {
        this.value = value;
        this.serialNumber = serialNumber;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }
}
