package per.sc.service;

import per.sc.pojo.MessageBoard;

import java.util.List;

/**
 * 留言墙
 * @author Administrator
 * @date 2019/11/18
 */
public interface MessageBoardServiceI {

    /**
     * 添加留言
     * @param messageBoard
     */
    void sendMessageBoard(MessageBoard messageBoard);

    /**
     * init留言
     * @return
     */
    List<MessageBoard> queryMessageBoard();
}
