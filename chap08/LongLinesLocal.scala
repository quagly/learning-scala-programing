import scala.io.Source

// 8.2
// demonstrate using a local function
// instead of private method
object LongLinesLocal {

  def processFile(filename: String, width: Int) = {

    // when using a local function
    // do not need to pass parameters if they are in enclosing scope
    def processLine(line: String) = {
        if (line.length > width)
          println(filename + ": " + line.trim)
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(line)
  }

}
