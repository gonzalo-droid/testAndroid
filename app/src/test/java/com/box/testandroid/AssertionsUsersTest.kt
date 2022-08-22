package com.box.testandroid

import org.junit.*
import org.junit.Assert.*

class AssertionsUsersTest {

    private lateinit var bot: User

    // cycle of initialization variables in test
    // --->  BeforeClass
    // -->  Before
    // >  checkSameUsers
    // -->  After
    // -->  Before
    // >  checkHuman
    // -->  After
    // -->  Before
    // >  checkNotSameUsers
    // -->  After
    // -->  Before
    // >  checkNotNullUser
    // -->  After
    // --->  AfterClass
    companion object{

        /**
         * before and after class are must be static
         */

        private lateinit var juan: User

        @BeforeClass @JvmStatic
        fun setupCommon(){
            juan = User("Juan", 18, true)
            println("BeforeClass")
        }

        @AfterClass @JvmStatic
        fun tearDownCommon(){
            juan = User()
            println("AfterClass")
        }
    }

    @Before
    fun setup(){
        // init bot
        bot = User("8bit", 1, false)
        println("Before")
    }

    @After
    fun tearDown(){
        // reset bot, here we create a new instance of User and
        // delete the last instance
        bot = User()
        println("After")
    }

    @Test
    fun checkHumanTest() {
        val assertions = Assertions()
        assertFalse(assertions.checkHuman(bot))
        assertTrue(assertions.checkHuman(juan))
        println("checkHuman")
    }

    @Test
    fun checkNotNullUserTest(){
        assertNotNull(juan)
        println("checkNotNullUser")
    }

    @Test
    fun checkNotSameUsersTest(){
        assertNotSame(bot, juan)
        println("checkNotSameUsers")
    }

    @Test
    fun checkSameUsersTest(){
        val copyJuan = juan
        assertSame(copyJuan, juan)
        println("checkSameUsers")
    }
}