package celeb.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * singletone 프로그램 운영중 단 하나의 객체만을 사용.
 */
public class CelebManager {
    private static CelebManager instance;

    private List<Celeb> celebList = new ArrayList<>();

    /**
     * 외부에서는 객체 생성이 불가!
     */
    private CelebManager(){
        celebList.add(new Celeb(1, "daft punk", CelebType.Singer, "daftpunk.jpg"));
        celebList.add(new Celeb(2, "황제성", CelebType.Comedian, "hwang.jpg"));
        celebList.add(new Celeb(3, "juliaRoberts", CelebType.Actor, "juliaRoberts.jpg"));
        celebList.add(new Celeb(4, "mattDamon", CelebType.Actor, "mattDamon.jpg"));
        celebList.add(new Celeb(5, "양세찬", CelebType.Entertainer, "yang_se_chan.jpg"));
    }
    public static CelebManager getInstance(){
        if(instance == null){
            instance = new CelebManager();
        }
        return instance;
    }

    public List<Celeb> getCelebList() {
        return celebList;
    }
}
