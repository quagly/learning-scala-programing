object FindLongLinesLocal {
  def main(args: Array[String]) = {
    val width = args(0).toInt
    for (arg <- args.drop(1))
      LongLinesLocal.processFile(arg, width)
  }
}
