package com.fredcodecrafts.lab_week_06


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fredcodecrafts.lab_week_06.model.CatBreed
import com.fredcodecrafts.lab_week_06.model.CatModel
import com.fredcodecrafts.lab_week_06.model.Gender

private const val FEMALE_SYMBOL = "\u2640"
private const val MALE_SYMBOL = "\u2642"
private const val UNKNOWN_SYMBOL = "?"

class CatViewHolder(
    private val containerView: View,
    private val imageLoader: ImageLoader,
    private val onClickListener: CatAdapter.OnClickListener
) : RecyclerView.ViewHolder(containerView) {

    private val catPhotoView: ImageView by lazy { containerView.findViewById(R.id.cat_photo) }
    private val catNameView: TextView by lazy { containerView.findViewById(R.id.cat_name) }
    private val catBreedView: TextView by lazy { containerView.findViewById(R.id.cat_breed) }
    private val catBiographyView: TextView by lazy { containerView.findViewById(R.id.cat_biography) }
    private val catGenderView: TextView by lazy { containerView.findViewById(R.id.cat_gender) }

    fun bindData(cat: CatModel) {
        containerView.setOnClickListener { onClickListener.onItemClick(cat) }

        imageLoader.loadImage(cat.imageUrl, catPhotoView)
        catNameView.text = cat.name
        catBreedView.text = when (cat.breed) {
            CatBreed.AmericanCurl -> "American Curl"
            CatBreed.BalineseJavanese -> "Balinese-Javanese"
            CatBreed.ExoticShorthair -> "Exotic Shorthair"
        }
        catBiographyView.text = cat.biography
        catGenderView.text = when (cat.gender) {
            Gender.Female -> FEMALE_SYMBOL
            Gender.Male -> MALE_SYMBOL
            Gender.Unknown -> UNKNOWN_SYMBOL
        }
    }
}
