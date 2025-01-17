package movie

import norm.ParamSetter
import norm.Query
import norm.RowMapper
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Timestamp

public class GetAllMoviesParams

public class GetAllMoviesParamSetter : ParamSetter<GetAllMoviesParams> {
    public override fun map(ps: PreparedStatement, params: GetAllMoviesParams) {
    }
}

public data class GetAllMoviesResult(
    public val id: Int,
    public val title: String,
    public val startTime: Timestamp,
    public val endTime: Timestamp
)

public class GetAllMoviesRowMapper : RowMapper<GetAllMoviesResult> {
    public override fun map(rs: ResultSet): GetAllMoviesResult = GetAllMoviesResult(
        id = rs.getObject("id") as kotlin.Int,
        title = rs.getObject("title") as kotlin.String,
        startTime = rs.getObject("start_time") as java.sql.Timestamp,
        endTime = rs.getObject("end_time") as java.sql.Timestamp
    )
}

public class GetAllMoviesQuery : Query<GetAllMoviesParams, GetAllMoviesResult> {
    public override val sql: String = """
      |SELECT * FROM movies
      |""".trimMargin()

    public override val mapper: RowMapper<GetAllMoviesResult> = GetAllMoviesRowMapper()

    public override val paramSetter: ParamSetter<GetAllMoviesParams> = GetAllMoviesParamSetter()
}
