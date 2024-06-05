public class Log {
    String msg;

    Log(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "{msg='" + msg + '\'' + '}';
    }
}
