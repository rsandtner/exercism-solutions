object Flattener {

    fun flatten(source: Collection<Any?>): List<Any> = source
        .flatMap { if (it is Collection<*>) flatten(it) else listOf(it) }
        .filterNotNull()
}
