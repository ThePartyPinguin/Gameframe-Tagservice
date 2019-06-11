package tagservice.repository;

import org.springframework.web.context.annotation.ApplicationScope;
import tagservice.model.entity.Tag;

import java.util.Optional;

@ApplicationScope
public class TagCache extends DaoCache<ITagJpaImpl, Tag, Long> implements ITagDao {


    @Override
    public boolean exists(String tagString) {

        if(this.localCache.values().stream().anyMatch(tag -> tag.getTagString().equalsIgnoreCase(tagString)))
        {
            return true;
        }

        return this.jpaRepository.existsByTagString(tagString);
    }

    @Override
    public Tag getByTagString(String tagString) {
        Optional<Tag> foundTag = this.localCache.values().stream().filter(tag -> tag.getTagString().equalsIgnoreCase(tagString)).findFirst();

        if(foundTag.isPresent()){
            return foundTag.get();
        }

        foundTag = this.jpaRepository.getByTagString(tagString);

        return foundTag.orElse(null);

    }
}
