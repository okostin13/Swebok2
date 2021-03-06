import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@ManagedBean
@SessionScoped
public class GuestController {
    public GuestController() {

    }

    @Inject
    private ContentDAO contentDAO;

    private Chapter chapter;



    public List<Chapter> findAllChapters(){
        return contentDAO.findAllChapters();
    }

    public void findChapter(int id){

       chapter=contentDAO.findChapter(id);

    }
public String getTags(){
        if (chapter!=null)
        return  "Теги: "+ chapter.getTags();
        else
            return "";
}

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }


}
