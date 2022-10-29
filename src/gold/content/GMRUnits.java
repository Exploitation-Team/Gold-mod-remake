package gold.content;

import arc.graphics.*;
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
    rgbTrio;

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


    }
}
