/**
 *  Nama    : Aryalingga Karamasatya Radhiendra
 *  NIM     : 10118368
 *  Kelas   : AKBUL1
 */
import com.google.gson.annotations.SerializedName

data class Superhero(
    val id: String,
    val name: String,
    val powerstats: Powerstats,
    val biography: Biography,
    val appearance: Appearance,
    val work: Work,
    val connections: Connections,
    val image: Image
)

data class Powerstats(
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
)

data class Biography(
    @SerializedName("full-name") val fullName: String,
    @SerializedName("alter-egos") val alterEgos: String,
    @SerializedName("place-of-birth") val placeOfBirth: String,
    @SerializedName("first-appearance") val firstAppearance: String,
    val publisher: String,
    val alignment: String
)

data class Appearance(
    val gender: String,
    val race: String,
    val height: List<String>,
    val weight: List<String>,
    @SerializedName("eye-color") val eyeColor: String,
    @SerializedName("hair-color") val hairColor: String
)

data class Work(
    val occupation: String,
    val base: String
)

data class Connections(
    @SerializedName("group-affiliation") val groupAffiliation: String,
    val relatives: String
)

data class Image(
    val url: String
)
