package com.KoreaIT.sw.demo.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ReactionPointRepository {

	@Select("""
			<script>
				SELECT IFNULL(SUM(RP.point),0)
				FROM reactionPoint AS RP
				WHERE RP.relTypeCode = #{relTypeCode}
				AND RP.relId = #{id}
				AND RP.memberId = #{actorId}
			</script>
			""")
	public int getSumReactionPointByMemberId(int actorId, String relTypeCode, int id);

	@Insert("""
			<script>
				INSERT INTO reactionPoint
				SET regDate = NOW(),
				updateDate = NOW(),
				relTypeCode = #{relTypeCode},
				relId = #{id},
				memberId = #{actorId},
				`point` = 1
			</script>
			""")
	public int addGoodReactionPoint(int actorId, String relTypeCode, int id);

	@Insert("""
			<script>
				INSERT INTO reactionPoint
				SET regDate = NOW(),
				updateDate = NOW(),
				relTypeCode = #{relTypeCode},
				relId = #{id},
				memberId = #{actorId},
				`point` = -1
			</script>
			""")
	public int addBadReactionPoint(int actorId, String relTypeCode, int id);

	@Delete("""
			DELETE FROM reactionPoint
			WHERE relTypeCode = #{relTypeCode}
			AND relId = #{relId}
			AND memberId = #{actorId}
			""")
	public void deleteGoodReactionPoint(int actorId, String relTypeCode, int relId);

	@Delete("""
			DELETE FROM reactionPoint
			WHERE relTypeCode = #{relTypeCode}
			AND relId = #{relId}
			AND memberId = #{actorId}
			""")
	public void deleteBadReactionPoint(int actorId, String relTypeCode, int relId);
}
