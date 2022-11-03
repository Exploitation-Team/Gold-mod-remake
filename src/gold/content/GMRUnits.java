package gold.content;

import arc.graphics.*;
import gold.graphics.*;
import mindustry.ai.types.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.type.weapons.*;
import mindustry.world.meta.*;
import mindustry.content.*;


public class GMRUnits {
    public static UnitType
            //bosses
    rgbTrio, baldiMech,
            //core
    sigma
    ;
    public static void load(){
        rgbTrio = new MissileUnitType("rgb-trio"){{
            speed = 0f;
            hitSize = 0f;
            flying = true;
            lifetime = 0;
            createWreck = false;
            constructor = TimedKillUnit::create;
            hidden = false;
            weapons.add(new Weapon("spawner"){{
                reload = 100f;
                x = 0f;
                y = 0f;
                mirror = false;
                top = false;
                shootOnDeath = true;
                shootCone = 360;
                bullet = new BasicBulletType(){{
                    damage = 0f;
                    lifetime = 0f;
                    spawnUnit = new UnitType("bloodsteel"){{
                        health = 16000;
                        speed = 1.3f;
                        hitSize = 40f;
                        drag = 0.02f;
                        flying = true;
                        range = 300f;
                        faceTarget = true;
                        constructor = UnitEntity::create;
                        engineOffset = 14f;
                        engineSize = 5f;
                        targetFlags = new BlockFlag[]{BlockFlag.turret, null};
                        weapons.add(new Weapon("blood-laser"){{
                            continuous = true;
                            reload = 160f;
                            x = 0f;
                            y = 6f;
                            top = false;
                            bullet = new ContinuousLaserBulletType(){{
                                damage = 60f;
                                length = 300f;
                                lifetime = 140f;
                            }};
                        }});
                    }};
                }};
            }},
                    new Weapon("spawner"){
                        {
                            reload = 100f;
                            x = 0f;
                            y = 0f;
                            mirror = false;
                            top = false;
                            shootOnDeath = true;
                            shootCone = 360;
                            bullet = new BasicBulletType(){{
                                damage = 0f;
                                lifetime = 0f;
                                spawnUnit = new UnitType("pladium"){{
                                    health = 12000;
                                    speed = 1.7f;
                                    hitSize = 40f;
                                    drag = 0.02f;
                                    flying = true;
                                    range = 200f;
                                    faceTarget = true;
                                    constructor = UnitEntity::create;
                                    targetFlags = new BlockFlag[]{BlockFlag.generator, null};
                                    engineOffset = 14f;
                                    engineSize = 5f;
                                    weapons.add(new Weapon("palladium-minigun"){{
                                        reload = 200f;
                                        x = 0f;
                                        y = 7f;
                                        top = false;
                                        shoot.shots = 6;
                                        shoot.shotDelay = 8;
                                        bullet = new BasicBulletType(){{
                                            damage = 100f;
                                            speed = 8;
                                            lifetime = 25f;
                                            width = 20f;
                                            height = 26f;
                                        }};
                                    }});
                                }};;
                            }};
                        }},
                    new Weapon("spawner"){{
                        reload = 100f;
                        x = 0f;
                        y = 0f;
                        mirror = false;
                        top = false;
                        shootOnDeath = true;
                        shootCone = 360;
                        bullet = new BasicBulletType(){{
                            damage = 0f;
                            lifetime = 0f;
                            spawnUnit = new UnitType("graveles"){{
                                health = 20000;
                                speed = 1.4f;
                                hitSize = 40f;
                                drag = 0.02f;
                                flying = true;
                                range = 400f;
                                faceTarget = true;
                                constructor = UnitEntity::create;
                                engineOffset = 14f;
                                engineSize = 5f;
                                targetFlags = new BlockFlag[]{BlockFlag.factory, BlockFlag.storage, null};
                                weapons.add(new Weapon("blood-laser"){{
                                    reload = 260f;
                                    x = 0f;
                                    y = 6f;
                                    top = false;
                                    shoot = new ShootSpread(60, 2f);
                                    bullet = new BasicBulletType(){{
                                        damage = 20f;
                                        speed = 5;
                                        lifetime = 80f;
                                        width = 8f;
                                        height = 6f;
                                    }};
                                }});
                            }};;
                        }};
                    }});
        }};
        baldiMech = new UnitType("baldi-mech"){{
            constructor = MechUnit::create;
            health = 30000;
            speed = 0.15f;
            hitSize = 11f;
            flying = false;
            range = 60f;
            weapons.add(new Weapon("ruler"){{
                top = false;
                mirror = false;
                reload = 140f;
                x = 0f;
                y = 2f;
                shootSound = GMRSounds.rulerSlap;
                ejectEffect = Fx.casing1;

                bullet = new LaserBulletType(100000000000f){{
                    recoil = -15f;
                    width = 1f;
                    length = 60f;
                    lifetime = 6f;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                    colors = new Color[]{Color.red,Color.red,Color.red};
                }};
            }});
        }};
        sigma = new UnitType("sigma"){{
            aiController = BuilderAI::new;
            isEnemy = false;
            constructor = UnitEntity::create;

            lowAltitude = true;
            flying = true;
            mineSpeed = 9f;
            mineTier = 3;
            buildSpeed = 1.5f;
            drag = 0.04f;
            speed = 3.75f;
            rotateSpeed = 20f;
            accel = 0.11f;
            itemCapacity = 80;
            health = 430f;
            engineOffset = 6f;
            hitSize = 13f;
            weapons.add(new Weapon("gold-blaster-weapon"){{
                top = false;
                mirror = false;
                reload = 50f;
                x = 0f;
                y = 3f;

                ejectEffect = Fx.casing1;

                bullet = new BasicBulletType(4f, 16){{

                    width = 8f;
                    height = 8f;
                    lifetime = 55f;
                    shootEffect = Fx.thoriumShoot;
                    smokeEffect = Fx.shootSmallSmoke;
                    buildingDamageMultiplier = 0.01f;
                    sprite = "circle-bullet";
                    splashDamage = 30f;
                    splashDamageRadius = 20f;
                    backColor = GMRPal.goldHeat;
                    frontColor = Color.white;
                }};
            }});
        }};

    }
}
