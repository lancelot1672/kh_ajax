package name.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameManager {
    private List<String> nameList;
    private static NameManager instance;

    public NameManager(){
        this.nameList = Arrays.asList("고두현", "권민지", "김경한", "김동률", "김용민", "김은주", "김정헌", "김지은", "김하늘", "김현우", "박민서", "박수진", "박지수", "박홍준", "안태현", "유혜리", "이경석", "이보미", "이은민", "이은지", "장은성", "전인찬", "정서영", "정의한", "최윤서");

    }

    public List<String> getNameList() {
        return nameList;
    }

    public static NameManager getInstance(){
        if(instance == null){
            instance = new NameManager();
        }
        return instance;
    }
}
