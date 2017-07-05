name := "S3Mock-Test"
scalaVersion := "2.11.8"
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")
scalacOptions ++= Seq("-target:jvm-1.8")



libraryDependencies ++= Seq(
  "com.amazonaws"                %  "aws-java-sdk-s3"             % "1.11.86",
  "com.typesafe"                 %  "config"                      % "1.3.0"
)


libraryDependencies ++= Seq(
  "org.scalatest"                %% "scalatest"                   % "3.0.1"    % "test",
  "org.mockito"                  %  "mockito-all"                 % "1.10.19"  % "test",
  "io.findify"                   %% "s3mock"                      % "0.2.3"    % "test"
)

resolvers ++= Seq(
  "Sonatype"        at    "https://oss.sonatype.org/"
)

fork in Test := true
parallelExecution in Test := false
