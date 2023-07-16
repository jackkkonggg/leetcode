package org.jackkkonggg.hard

import spock.lang.Shared
import spock.lang.Specification

class SmallestSufficientTeamTest extends Specification {
    @Shared
    def smallestSufficientTeam = new SmallestSufficientTeam()

    def "example tests"() {
        expect:
        result == Arrays.stream(smallestSufficientTeam.smallestSufficientTeam(req_skills as String[], people)).boxed().toList()

        where:
        req_skills                                                 | people                                                                                                                                                     | result
        ["java", "nodejs", "reactjs"]                              | [["java"], ["nodejs"], ["nodejs", "reactjs"]]                                                                                                              | [0, 2]
        ["algorithms", "math", "java", "reactjs", "csharp", "aws"] | [["algorithms", "math", "java"], ["algorithms", "math", "reactjs"], ["java", "csharp", "aws"], ["reactjs", "csharp"], ["csharp", "math"], ["aws", "java"]] | [1, 2]
    }
}
