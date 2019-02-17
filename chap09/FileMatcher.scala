/* I got confused between an object and a class here
 * and object does not need to be instantiated
 * so just run this with code like
 * FileMatcher.filesEnding("scala")
 * there is no new FileMatcher()
 * that is for classes only
 */
object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

  // reusalble generic file matcher
  private def filesMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
      yield file

  /*
   * underscore _ gets replaced with file.getName in the FileMatching method
   * just need to pass the query string
   * and create a closre with that string to pass to the matcher
   * how could this be abstracted further to match on something other than
   * getName()?
   */
  // query string filename ends with
  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))

  // query string filename contains
  def filesContaining(query: String) =
    filesMatching(_.contains(query))

  // query string regex to match
  def filesRegex(query: String) =
    filesMatching(_.matches(query))
}
