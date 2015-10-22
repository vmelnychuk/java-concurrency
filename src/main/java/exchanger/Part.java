package exchanger;

import java.util.concurrent.Exchanger;

public class Part implements Runnable {
    private Integer id;
    private Integer paidId;
    private Exchanger<Integer> exchanger;

    public Part(Integer id, Exchanger<Integer> exchanger) {
        this.id = id;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            //System.out.println("id: " + id + " is exchanging");
            paidId = exchanger.exchange(id);
            //System.out.println("id: " + id + " is exchanged to " + paidId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaidId() {
        return paidId;
    }

    public void setPaidId(Integer paidId) {
        this.paidId = paidId;
    }
}
