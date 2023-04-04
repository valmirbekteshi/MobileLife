package vb.mobilelife

import org.junit.Assert.assertEquals
import org.junit.Test
import vb.mobilelife.data.ImageModel

class ListItemTest {

    @Test
    fun testImageModelProperties() {
        val image = R.drawable.ic_launcher_background
        val title = "My Title"
        val listItem = ImageModel(image, title)

        assertEquals(image, listItem.image)
        assertEquals(title, listItem.title)
    }
}
