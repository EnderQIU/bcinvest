package cn.ssyram.blockchain.innerlogic.test;

public class Logger {
    public static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Logger
            .class.getName());

    public static void log(String info) {
        logger.info(info);
    }
}
